package com.example.avocadoandroid.recycler_expandable

data class ExpandableItem(val icon:Int,val title:String,val mutableList: MutableList<ChildItem>
,val isExpanded:Boolean)