package org.apache.eventmesh.common.protocol.grpc.adminserver;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event_mesh_admin_service.proto

public final class EventMeshAdminService {
  private EventMeshAdminService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Metadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Metadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Metadata_HeadersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Metadata_HeadersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Payload_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Payload_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\036event_mesh_admin_service.proto\032\031google" +
      "/protobuf/any.proto\"q\n\010Metadata\022\014\n\004type\030" +
      "\003 \001(\t\022\'\n\007headers\030\007 \003(\0132\026.Metadata.Header" +
      "sEntry\032.\n\014HeadersEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005v" +
      "alue\030\002 \001(\t:\0028\001\"J\n\007Payload\022\033\n\010metadata\030\002 " +
      "\001(\0132\t.Metadata\022\"\n\004body\030\003 \001(\0132\024.google.pr" +
      "otobuf.Any2B\n\024AdminBiStreamService\022*\n\016in" +
      "vokeBiStream\022\010.Payload\032\010.Payload\"\000(\0010\00124" +
      "\n\014AdminService\022$\n\014invokeStream\022\010.Payload" +
      "\032\010.Payload\"\000B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
        });
    internal_static_Metadata_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Metadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Metadata_descriptor,
        new String[] { "Type", "Headers", });
    internal_static_Metadata_HeadersEntry_descriptor =
      internal_static_Metadata_descriptor.getNestedTypes().get(0);
    internal_static_Metadata_HeadersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Metadata_HeadersEntry_descriptor,
        new String[] { "Key", "Value", });
    internal_static_Payload_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Payload_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Payload_descriptor,
        new String[] { "Metadata", "Body", });
    com.google.protobuf.AnyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
