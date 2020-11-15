package net.kiranatos.youtube.g11galaxian;

import java.io.InputStream;

public class Const {
    //public static final int     FRAME_WIDTH     = 800;
    //public static final int     FRAME_HEIGHT    = 600;
    public static final int     FRAME_WIDTH     = 620;
    public static final int     FRAME_HEIGHT    = 480;
    public static final String  FRAME_TITLE     = "2D_Games";
    public static final int     CLEAR_COLOR     = 0xFF000000; //0xFF22A04C;
    ///public static final int     CLEAR_COLOR     = 0xFF22A04C;
    public static final int     NUM_BUFFER      = 3;

    public static final long    SECOND          = 1000000000l;
    public static final float   UPDATE_DATA     = 60f;
    public static final float   UPDATE_INTERVAL = SECOND / UPDATE_DATA;
    public static final long    IDLE_TIME       = 1; //время отдыха в (мс)

    //public static final String  ATLAS_FILE_NAME = "texture_atlas.png";
    //public static final InputStream  ATLAS_FILE_NAME    = Const.class.getClassLoader().getResourceAsStream("atlas/texture_atlas.png"); //via Maven
    public static final InputStream  ATLAS_FILE_NAME    = Const.class.getClassLoader().getResourceAsStream("net/kiranatos/youtube/g11galaxian/atlas/texture_atlas.png");

    public static final float   BULLET_SPEED    = 7.0f;

    public static final float   BULLET_DAMAGE_0 = 1.0f;
    public static final float   BULLET_DAMAGE_1 = 1.0f;

    public static final float   ENEMY_SPEED_0   = 5.0f;
    public static final float   ENEMY_SPEED_1   = 2.0f;
    public static final float   ENEMY_SPEED_2   = 5.0f;
    public static final float   ENEMY_SPEED_3   = 5.0f;

    public static final float   ENEMY_HEALTH_0  = 1.0f;
    public static final float   ENEMY_HEALTH_1  = 1.0f;
    public static final float   ENEMY_HEALTH_2  = 2.0f;
    public static final float   ENEMY_HEALTH_3  = 3.0f;

   // public static final float   ENEMY_Y_START   = (float)FRAME_HEIGHT * 0.1f;
    public static final float   ENEMY_Y_START   = -20f;

    public static final int     ENEMY_NUM_MAX   = 20;

    public static final int     OBJECT_NUM_MAX  = 30;

    public static final int   START = 1;
    public static final int   STOP  = 0;
}
