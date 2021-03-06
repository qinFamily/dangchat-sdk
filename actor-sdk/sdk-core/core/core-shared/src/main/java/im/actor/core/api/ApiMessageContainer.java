package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ApiMessageContainer extends BserObject {

    private int senderUid;
    private long rid;
    private long date;
    private ApiMessage message;
    private ApiMessageState state;
    private List<ApiMessageReaction> reactions;
    private ApiMessageAttributes attribute;
    private ApiQuotedMessage quotedMessage;

    public ApiMessageContainer(int senderUid, long rid, long date, @NotNull ApiMessage message, @Nullable ApiMessageState state, @NotNull List<ApiMessageReaction> reactions, @Nullable ApiMessageAttributes attribute, @Nullable ApiQuotedMessage quotedMessage) {
        this.senderUid = senderUid;
        this.rid = rid;
        this.date = date;
        this.message = message;
        this.state = state;
        this.reactions = reactions;
        this.attribute = attribute;
        this.quotedMessage = quotedMessage;
    }

    public ApiMessageContainer() {

    }

    public int getSenderUid() {
        return this.senderUid;
    }

    public long getRid() {
        return this.rid;
    }

    public long getDate() {
        return this.date;
    }

    @NotNull
    public ApiMessage getMessage() {
        return this.message;
    }

    @Nullable
    public ApiMessageState getState() {
        return this.state;
    }

    @NotNull
    public List<ApiMessageReaction> getReactions() {
        return this.reactions;
    }

    @Nullable
    public ApiMessageAttributes getAttribute() {
        return this.attribute;
    }

    @Nullable
    public ApiQuotedMessage getQuotedMessage() {
        return this.quotedMessage;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.senderUid = values.getInt(1);
        this.rid = values.getLong(2);
        this.date = values.getLong(3);
        this.message = ApiMessage.fromBytes(values.getBytes(5));
        int val_state = values.getInt(6, 0);
        if (val_state != 0) {
            this.state = ApiMessageState.parse(val_state);
        }
        List<ApiMessageReaction> _reactions = new ArrayList<ApiMessageReaction>();
        for (int i = 0; i < values.getRepeatedCount(7); i ++) {
            _reactions.add(new ApiMessageReaction());
        }
        this.reactions = values.getRepeatedObj(7, _reactions);
        this.attribute = values.optObj(8, new ApiMessageAttributes());
        this.quotedMessage = values.optObj(9, new ApiQuotedMessage());
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.senderUid);
        writer.writeLong(2, this.rid);
        writer.writeLong(3, this.date);
        if (this.message == null) {
            throw new IOException();
        }

        writer.writeBytes(5, this.message.buildContainer());
        if (this.state != null) {
            writer.writeInt(6, this.state.getValue());
        }
        writer.writeRepeatedObj(7, this.reactions);
        if (this.attribute != null) {
            writer.writeObject(8, this.attribute);
        }
        if (this.quotedMessage != null) {
            writer.writeObject(9, this.quotedMessage);
        }
    }

    @Override
    public String toString() {
        String res = "struct MessageContainer{";
        res += "senderUid=" + this.senderUid;
        res += ", rid=" + this.rid;
        res += ", date=" + this.date;
        res += ", message=" + this.message;
        res += ", reactions=" + this.reactions;
        res += ", attribute=" + this.attribute;
        res += ", quotedMessage=" + this.quotedMessage;
        res += "}";
        return res;
    }

}
