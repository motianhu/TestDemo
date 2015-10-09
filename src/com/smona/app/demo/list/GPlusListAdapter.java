package com.smona.app.demo.list;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * 
 * @author <a href="http://www.hugofernandes.pt">Hugo Fernandes</a>
 * 
 */
public abstract class GPlusListAdapter extends GenericBaseAdapter {
    protected static final String[] URLS1 = {
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/D3636D22BE25D379D0C41BDACB037471_Being-with-you-is-like-walking-on-a-very-clear-morning.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/99C55E5916CA96ECDB90B47EA498053B_myheart.jpg" };

    protected static final String[] URLS2 = {
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/45EDC4F3469243D113000A3D0213C63B_be-the-world.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/2321D2196365A7DA1681955DA4F4AC3A_heartforever.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/E4488F21ADB6092B661B3AAE4089EF23_london.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/B05641A812EA9072DB010A36B5F0CA8E_heart.jpg" };

    protected static final String[] URLS3 = {

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",

            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/uj5mbefhgo8koe5n5703giupc5/1080x1920/344B0C97CE570B3CA1D32F8FDE169AA7_flowers.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/E3CFE195672DFBAC9AE02090416660D0_give_me_wings_to_fly.jpg",
            "http://assetsdl.gioneemobile.net/attachs/theme/wallpaper/2015/07/561voah051v3proh6qulbohfb1/1080x1920/479BDB986CE61C2E78CF86E3ED672D95_Fading-is-true-while-flowering-is-past.jpg" };

    public GPlusListAdapter(Context context,
            SpeedScrollListener scrollListener, List<? extends Object> items) {
        super(context, scrollListener, items);
    }

    static class ViewHolder {
        ImageView image1;
        ImageView image2;
        ImageView image3;
    }

    @Override
    protected void defineInterpolator() {
        interpolator = new DecelerateInterpolator();
    }

    @Override
    public View getAnimatedView(int position, View convertView, ViewGroup parent) {
        v = getRowView(position, convertView, parent);

        if (v != null && //!positionsMapper.get(position)
                position > previousPostition) {
            // ){
            speed = scrollListener.getSpeed();

            animDuration = (((int) speed) == 0) ? ANIM_DEFAULT_DURATION
                    : (long) (1 / speed * 15000);

            if (animDuration > ANIM_DEFAULT_DURATION) {
                animDuration = ANIM_DEFAULT_DURATION;
            }

            previousPostition = position;

            v.setTranslationX(0.0F);
            v.setTranslationY(height);
            v.setRotationX(45.0F);
            v.setScaleX(0.7F);
            v.setScaleY(0.55F);

            ViewPropertyAnimator localViewPropertyAnimator = v.animate()
                    .rotationX(0.0F).rotationY(0.0F).translationX(0)
                    .translationY(0).setDuration(animDuration).scaleX(1.0F)
                    .scaleY(1.0F).setInterpolator(interpolator);

            localViewPropertyAnimator.setStartDelay(0).start();
            positionsMapper.put(position, true);
        }
        return v;
    }

    /**
     * Get a View that displays the data at the specified position in the data
     * set. You can either create a View manually or inflate it from an XML
     * layout file. When the View is inflated, the parent View (GridView,
     * ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     * 
     * @param position
     *            The position of the item within the adapter's data set of the
     *            item whose view we want.
     * @param convertView
     *            The old view to reuse, if possible. Note: You should check
     *            that this view is non-null and of an appropriate type before
     *            using. If it is not possible to convert this view to display
     *            the correct data, this method can create a new view.
     * @param parent
     *            The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    protected abstract View getRowView(int position, View convertView,
            ViewGroup parent);

}
