package com.gafasmatch.visualstyle.data

object DataSource {
    fun getGafaList(): MutableList<Gafa> {
        val gafasList = mutableListOf<Gafa>(
            Gafa(" WAYFARER",
                "Estilo icónico de gafas de sol que se caracterizan por su diseño distintivo y atemporal.",
                "https://hips.hearstapps.com/hmg-prod/images/jude-law-gafas-wayfarer-ray-ban-1603779142.jpg?crop=0.524xw:0.571xh;0.119xw,0.0213xh&resize=768:*",
                "Soloptical"),
            Gafa(" REDONDAS",
                "Ofrece una apariencia retro y vintage que evoca un aire de elegancia y sofisticación.",
                "https://i.etsystatic.com/9503960/r/il/2037c8/2802818198/il_570xN.2802818198_pk99.jpg",
            "Multiopticas"),
            Gafa("RECTANGULAR",
                "Esta forma geométrica ofrece líneas limpias y una apariencia moderna que puede complementar una variedad de formas faciales.",
                "https://img.kwcdn.com/product/Fancyalgo/VirtualModelMatting/5ef356608645ed68f374b4e0f10bb979.jpg?imageMogr2/auto-orient%7CimageView2/2/w/800/q/70/format/webp",
                "Opticalia"),
            Gafa("PANTOS",
                "Opción de moda popular que combina elementos de los estilos de gafas redondas y rectangulares",
                "https://i.pinimg.com/236x/94/ea/32/94ea3255f1ee1cddb4c227758fe420fb.jpg",
                "Alain Afflelou"),
        )
        return gafasList
    }
}