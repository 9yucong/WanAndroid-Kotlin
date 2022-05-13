package com.cong.wanandroid.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cong.wanandroid.R
import com.cong.wanandroid.databinding.ItemArticleBinding
import com.cong.wanandroid.net.bean.Article
import com.google.android.material.chip.Chip

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月13日
 */
class ArticleAdapter : PagingDataAdapter<Article, ArticleAdapter.ArticleViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.tvAuthor.text = if (TextUtils.isEmpty(article?.author)) "匿名用户" else article?.author
        holder.tvContent.text = article?.title
        article?.tags?.forEach {
            holder.cgTag.removeAllViews()
            holder.cgTag.addView(createTagChip(holder.cgTag.context, it.name))
        }
    }

    private fun createTagChip(context: Context, name: String): Chip {
        val chip = LayoutInflater.from(context).inflate(R.layout.item_tag_chip, null) as Chip
        chip.text = name
        return chip
    }

    inner class ArticleViewHolder(binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvAuthor = binding.tvAuthor
        val tvContent = binding.tvContent
        val cgTag = binding.cgTag
    }
}