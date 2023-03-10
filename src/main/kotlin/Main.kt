package ru.netology

class NoPostException(message: String): RuntimeException(message)
object Wall {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val newPostId: Int
        if(posts.isNotEmpty()) {
            newPostId = posts[posts.lastIndex].id + 1
        }
        else newPostId = 1
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
    fun addComment(postId: Int, comment: Comment): Comment {
        for(i in posts.indices) {
            if(posts[i].id == postId) {
                posts[i].comments += comment
                return comment
            }
        }
        throw NoPostException("no such post")
    }

    fun clearWall() {
        posts = emptyArray()
    }
}

fun main() {

}