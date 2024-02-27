package com.gafasmatch.visualstyle.data

object DataSource {
    fun getGafaList(): MutableList<Gafa> {
        val gafasList = mutableListOf<Gafa>(
            Gafa(" WAYFARER",
                "",
                "https://assets.stickpng.com/images/58728270f3a71010b5e8ef11.png"),
            Gafa(" REDONDAS",
                "",
                "https://assets.stickpng.com/images/58728270f3a71010b5e8ef11.png"),
            Gafa("RECTANGULAR",
                "",
                "https://assets.stickpng.com/images/58728270f3a71010b5e8ef11.png"),
            Gafa("PANTOS",
                "",
                "https://assets.stickpng.com/images/58728270f3a71010b5e8ef11.png"),
        )
        return gafasList
    }
}