package ru.netology

data class Post (
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val comments: Comments?
        ) {
    override fun toString(): String {
        var printPostProp: String
        printPostProp = "id: $id, ownerId: $ownerId, fromId: $fromId, date: $date, text: $text, canPin; $canPin," +
                    "canDelete: $canDelete, canEdit: $canEdit, isPinned: $isPinned"
        if(comments == null) {
            printPostProp += "Comments: $comments.count"
        }
        return printPostProp
    }
}

data class Comments (
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
        ) {

}