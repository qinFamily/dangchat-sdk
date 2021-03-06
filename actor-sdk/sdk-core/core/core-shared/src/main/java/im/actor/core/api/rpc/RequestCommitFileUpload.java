package im.actor.core.api.rpc;
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
import im.actor.core.api.*;

public class RequestCommitFileUpload extends Request<ResponseCommitFileUpload> {

    public static final int HEADER = 0x7a;
    public static RequestCommitFileUpload fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestCommitFileUpload(), data);
    }

    private byte[] uploadKey;
    private String fileName;

    public RequestCommitFileUpload(@NotNull byte[] uploadKey, @NotNull String fileName) {
        this.uploadKey = uploadKey;
        this.fileName = fileName;
    }

    public RequestCommitFileUpload() {

    }

    @NotNull
    public byte[] getUploadKey() {
        return this.uploadKey;
    }

    @NotNull
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uploadKey = values.getBytes(1);
        this.fileName = values.getString(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.uploadKey == null) {
            throw new IOException();
        }
        writer.writeBytes(1, this.uploadKey);
        if (this.fileName == null) {
            throw new IOException();
        }
        writer.writeString(2, this.fileName);
    }

    @Override
    public String toString() {
        String res = "rpc CommitFileUpload{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
