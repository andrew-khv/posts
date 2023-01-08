package ru.netology

object Wall {
    private var posts = emptyArray<Post>()
    private var newPostId = posts.lastIndex + 2

    fun add(post: Post): Post {
        posts += post.copy(id = newPostId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (i in posts.indices) {
            if (posts[i].id == post.id) {
                posts[i] = post.copy(id = posts[i].id, ownerId = posts[i].ownerId, date = posts[i].date)
                return true
            }
        }
        return false
    }

    fun clearWall() {
        posts = emptyArray<Post>()
    }
}

fun main() {

}