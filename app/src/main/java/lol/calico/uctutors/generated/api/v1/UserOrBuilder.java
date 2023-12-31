// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/user.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.v1.User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1 [json_name = "id"];</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1 [json_name = "id"];</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>.google.protobuf.Timestamp joined = 2 [json_name = "joined"];</code>
   * @return Whether the joined field is set.
   */
  boolean hasJoined();
  /**
   * <code>.google.protobuf.Timestamp joined = 2 [json_name = "joined"];</code>
   * @return The joined.
   */
  com.google.protobuf.Timestamp getJoined();
  /**
   * <code>.google.protobuf.Timestamp joined = 2 [json_name = "joined"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getJoinedOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp updated = 3 [json_name = "updated"];</code>
   * @return Whether the updated field is set.
   */
  boolean hasUpdated();
  /**
   * <code>.google.protobuf.Timestamp updated = 3 [json_name = "updated"];</code>
   * @return The updated.
   */
  com.google.protobuf.Timestamp getUpdated();
  /**
   * <code>.google.protobuf.Timestamp updated = 3 [json_name = "updated"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getUpdatedOrBuilder();

  /**
   * <code>string email = 4 [json_name = "email"];</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 4 [json_name = "email"];</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string first_name = 5 [json_name = "firstName"];</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string first_name = 5 [json_name = "firstName"];</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 6 [json_name = "lastName"];</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 6 [json_name = "lastName"];</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>.api.v1.School school = 7 [json_name = "school"];</code>
   * @return The enum numeric value on the wire for school.
   */
  int getSchoolValue();
  /**
   * <code>.api.v1.School school = 7 [json_name = "school"];</code>
   * @return The school.
   */
  lol.calico.uctutors.generated.api.v1.School getSchool();

  /**
   * <code>uint32 class_of = 8 [json_name = "classOf"];</code>
   * @return The classOf.
   */
  int getClassOf();

  /**
   * <code>string bio = 9 [json_name = "bio"];</code>
   * @return The bio.
   */
  java.lang.String getBio();
  /**
   * <code>string bio = 9 [json_name = "bio"];</code>
   * @return The bytes for bio.
   */
  com.google.protobuf.ByteString
      getBioBytes();

  /**
   * <code>string avatar_id = 10 [json_name = "avatarId"];</code>
   * @return The avatarId.
   */
  java.lang.String getAvatarId();
  /**
   * <code>string avatar_id = 10 [json_name = "avatarId"];</code>
   * @return The bytes for avatarId.
   */
  com.google.protobuf.ByteString
      getAvatarIdBytes();

  /**
   * <code>string banner_id = 11 [json_name = "bannerId"];</code>
   * @return The bannerId.
   */
  java.lang.String getBannerId();
  /**
   * <code>string banner_id = 11 [json_name = "bannerId"];</code>
   * @return The bytes for bannerId.
   */
  com.google.protobuf.ByteString
      getBannerIdBytes();

  /**
   * <code>repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];</code>
   */
  java.util.List<lol.calico.uctutors.generated.api.v1.CampusAvailability> 
      getCampusAvailabilityList();
  /**
   * <code>repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];</code>
   */
  lol.calico.uctutors.generated.api.v1.CampusAvailability getCampusAvailability(int index);
  /**
   * <code>repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];</code>
   */
  int getCampusAvailabilityCount();
  /**
   * <code>repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];</code>
   */
  java.util.List<? extends lol.calico.uctutors.generated.api.v1.CampusAvailabilityOrBuilder> 
      getCampusAvailabilityOrBuilderList();
  /**
   * <code>repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];</code>
   */
  lol.calico.uctutors.generated.api.v1.CampusAvailabilityOrBuilder getCampusAvailabilityOrBuilder(
      int index);

  /**
   * <code>repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];</code>
   */
  java.util.List<lol.calico.uctutors.generated.api.v1.VirtualAvailability> 
      getVirtualAvailabilityList();
  /**
   * <code>repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];</code>
   */
  lol.calico.uctutors.generated.api.v1.VirtualAvailability getVirtualAvailability(int index);
  /**
   * <code>repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];</code>
   */
  int getVirtualAvailabilityCount();
  /**
   * <code>repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];</code>
   */
  java.util.List<? extends lol.calico.uctutors.generated.api.v1.VirtualAvailabilityOrBuilder> 
      getVirtualAvailabilityOrBuilderList();
  /**
   * <code>repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];</code>
   */
  lol.calico.uctutors.generated.api.v1.VirtualAvailabilityOrBuilder getVirtualAvailabilityOrBuilder(
      int index);

  /**
   * <code>repeated string topics = 14 [json_name = "topics"];</code>
   * @return A list containing the topics.
   */
  java.util.List<java.lang.String>
      getTopicsList();
  /**
   * <code>repeated string topics = 14 [json_name = "topics"];</code>
   * @return The count of topics.
   */
  int getTopicsCount();
  /**
   * <code>repeated string topics = 14 [json_name = "topics"];</code>
   * @param index The index of the element to return.
   * @return The topics at the given index.
   */
  java.lang.String getTopics(int index);
  /**
   * <code>repeated string topics = 14 [json_name = "topics"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the topics at the given index.
   */
  com.google.protobuf.ByteString
      getTopicsBytes(int index);

  /**
   * <code>uint32 tutor_score = 15 [json_name = "tutorScore"];</code>
   * @return The tutorScore.
   */
  int getTutorScore();

  /**
   * <code>uint32 tutee_score = 16 [json_name = "tuteeScore"];</code>
   * @return The tuteeScore.
   */
  int getTuteeScore();

  /**
   * <code>repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];</code>
   */
  java.util.List<lol.calico.uctutors.generated.api.v1.Experience> 
      getExperiencesList();
  /**
   * <code>repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];</code>
   */
  lol.calico.uctutors.generated.api.v1.Experience getExperiences(int index);
  /**
   * <code>repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];</code>
   */
  int getExperiencesCount();
  /**
   * <code>repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];</code>
   */
  java.util.List<? extends lol.calico.uctutors.generated.api.v1.ExperienceOrBuilder> 
      getExperiencesOrBuilderList();
  /**
   * <code>repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];</code>
   */
  lol.calico.uctutors.generated.api.v1.ExperienceOrBuilder getExperiencesOrBuilder(
      int index);
}
