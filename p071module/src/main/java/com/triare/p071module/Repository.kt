package com.triare.p071module

class Repository{

    fun getGoboById(id:Int):Gobo?{

        return list.find { it.id == id }
    }

    val list= listOf(

        Gobo(R.id.i0410,R.string.geo_0410,R.string.descr_geo_0410,R.mipmap.ic_geo_0410),
        Gobo(R.id.i0005,R.string.geo_0005,R.string.descr_geo_0005,R.mipmap.ic_geo_0005),
        Gobo(R.id.i0291,R.string.geo_0291,R.string.descr_geo_0291,R.mipmap.ic_geo_0291),
        Gobo(R.id.i0405,R.string.star_0405,R.string.descr_star_0405,R.mipmap.ic_star_0405),
        Gobo(R.id.i0009,R.string.star_0009,R.string.descr_star_0009,R.mipmap.ic_star_0009),
        Gobo(R.id.i0033,R.string.star_0033,R.string.descr_star_0033,R.mipmap.ic_star_0033),
        Gobo(R.id.i0375,R.string.mono_abs_0375,R.string.descr_mono_abs_0375,R.mipmap.ic_mono_abs_0375),
        Gobo( R.id.i0271,R.string.mono_abs_0271,R.string.descr_mono_abs_0271,R.mipmap.ic_mono_abs_0271),
        Gobo( R.id.i0632,R.string.mono_abs_0632,R.string.descr_mono_abs_0632,R.mipmap.ic_mono_abs_0632),
        Gobo( R.id.i0122,R.string.col_abs_0122,R.string.descr_col_abs_0122,R.mipmap.ic_col_abs_0122),
        Gobo(R.id.i0136,R.string.col_abs_0136,R.string.descr_col_abs_0136,R.mipmap.ic_col_abs_0136),
        Gobo( R.id.i0166,R.string.col_abs_0166,R.string.descr_col_abs_0166,R.mipmap.ic_col_abs_0166),
        Gobo(R.id.i0153,R.string.on_bb_0153,R.string.descr_on_bb_0153,R.mipmap.ic_on_bb_0153),
        Gobo(R.id.i0157,R.string.on_bb_0157,R.string.descr_on_bb_0157,R.mipmap.ic_on_bb_0157),
        Gobo(R.id.i0161,R.string.on_bb_0161,R.string.descr_on_bb_0161,R.mipmap.ic_on_bb_0161),
        Gobo(R.id.i0435,R.string.col_fill_0435,R.string.descr_col_fill_0435,R.mipmap.ic_col_fill_0435),
        Gobo( R.id.i0438,R.string.col_fill_0438,R.string.descr_col_fill_0438,R.mipmap.ic_col_fill_0438),
        Gobo( R.id.i0429,R.string.col_fill_0429,R.string.descr_col_fill_0429,R.mipmap.ic_col_fill_0429)
    )

}