// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package com.redick.example.protocol;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:protocol.User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   * @return The userId.
   */
  int getUserId();

  /**
   * <code>string username = 2;</code>
   * @return The username.
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 2;</code>
   * @return The bytes for username.
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string error = 3;</code>
   * @return Whether the error field is set.
   */
  boolean hasError();
  /**
   * <code>string error = 3;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <code>string error = 3;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>int32 code = 4;</code>
   * @return Whether the code field is set.
   */
  boolean hasCode();
  /**
   * <code>int32 code = 4;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <code>string name = 8;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 8;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.protocol.UserType userType = 9;</code>
   * @return The enum numeric value on the wire for userType.
   */
  int getUserTypeValue();
  /**
   * <code>.protocol.UserType userType = 9;</code>
   * @return The userType.
   */
  com.redick.example.protocol.UserType getUserType();

  /**
   * <code>repeated int32 roles = 10;</code>
   * @return A list containing the roles.
   */
  java.util.List<java.lang.Integer> getRolesList();
  /**
   * <code>repeated int32 roles = 10;</code>
   * @return The count of roles.
   */
  int getRolesCount();
  /**
   * <code>repeated int32 roles = 10;</code>
   * @param index The index of the element to return.
   * @return The roles at the given index.
   */
  int getRoles(int index);

  /**
   * <code>.protocol.File file = 11;</code>
   * @return Whether the file field is set.
   */
  boolean hasFile();
  /**
   * <code>.protocol.File file = 11;</code>
   * @return The file.
   */
  com.redick.example.protocol.FileOuterClass.File getFile();
  /**
   * <code>.protocol.File file = 11;</code>
   */
  com.redick.example.protocol.FileOuterClass.FileOrBuilder getFileOrBuilder();

  /**
   * <code>map&lt;string, string&gt; hobbys = 12;</code>
   */
  int getHobbysCount();
  /**
   * <code>map&lt;string, string&gt; hobbys = 12;</code>
   */
  boolean containsHobbys(
      java.lang.String key);
  /**
   * Use {@link #getHobbysMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getHobbys();
  /**
   * <code>map&lt;string, string&gt; hobbys = 12;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getHobbysMap();
  /**
   * <code>map&lt;string, string&gt; hobbys = 12;</code>
   */

  java.lang.String getHobbysOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; hobbys = 12;</code>
   */

  java.lang.String getHobbysOrThrow(
      java.lang.String key);

  public com.redick.example.protocol.User.MsgCase getMsgCase();
}
