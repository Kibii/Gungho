package com.gungho.game.networking;

import org.json.JSONObject;

/**
 * Created by jamesyanyuk on 1/23/16.
 */
public class Message {
    public final int MOVEMENT = 0;
    public final int ACTION = 1;

    private int playerID;
    private int type;
    private JSONObject body;

    public Message(int playerID, int type, JSONObject body) {
        this.playerID = playerID;
        this.type = type;
        this.body = body;
    }
}
