package com.example.customlistview
class ListData {
    var name: String
    var time: String
    var ingredients: Int
    var desc: Int
    var image: Int

    constructor(name: String, time: String, ingredients: Int, desc: Int, image: Int) {
        this.name = name
        this.time = time
        this.ingredients = ingredients
        this.desc = desc
        this.image = image
    }

    constructor() {
        name = ""
        time = ""
        ingredients = 0
        desc = 0
        image = 0
    }


    override fun toString(): String {
        return "ListData{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", ingredients=" + ingredients +
                ", desc=" + desc +
                ", image=" + image +
                '}'
    }

}