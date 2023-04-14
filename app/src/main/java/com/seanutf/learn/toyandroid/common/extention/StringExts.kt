package com.seanutf.learn.toyandroid.common.extention

/**
 * @Desc 针对字符串相关的扩展操作
 */

/**
 * 判断字符串是否
 * 1.为null
 * 2.为""
 * 3.为"null"
 * 以上几种情况针对客户端这种前端展示情况都是"无效的""无意义的"
 * 使用场景主要是针对后端返回的字符串字段，
 * 如果是客户端自己生成的字段可仅使用官方isNullOrEmpty()即可
 * 你不会写一段逻辑然后返回"null"的字符串吧？
 * */
fun String?.isInvalid(): Boolean {
    return this.isNullOrEmpty() || this == "null"
}