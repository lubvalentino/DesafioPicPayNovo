package com.example.DesafioPicPayNovo

fun String.unmask(): String {
    return this.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "").replace("[/]".toRegex(), "")
            .replace("[(]".toRegex(), "").replace(
                    "[ ]".toRegex(), ""
            ).replace("[:]".toRegex(), "").replace("[)]".toRegex(), "")
}