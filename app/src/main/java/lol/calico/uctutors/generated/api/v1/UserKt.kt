// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/user.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeuser")
public inline fun user(block: lol.calico.uctutors.generated.api.v1.UserKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.User =
  lol.calico.uctutors.generated.api.v1.UserKt.Dsl._create(lol.calico.uctutors.generated.api.v1.User.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.User`
 */
public object UserKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.User.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.User.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.User = _builder.build()

    /**
     * `string id = 1 [json_name = "id"];`
     */
    public var id: kotlin.String
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * `string id = 1 [json_name = "id"];`
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * `.google.protobuf.Timestamp joined = 2 [json_name = "joined"];`
     */
    public var joined: com.google.protobuf.Timestamp
      @JvmName("getJoined")
      get() = _builder.getJoined()
      @JvmName("setJoined")
      set(value) {
        _builder.setJoined(value)
      }
    /**
     * `.google.protobuf.Timestamp joined = 2 [json_name = "joined"];`
     */
    public fun clearJoined() {
      _builder.clearJoined()
    }
    /**
     * `.google.protobuf.Timestamp joined = 2 [json_name = "joined"];`
     * @return Whether the joined field is set.
     */
    public fun hasJoined(): kotlin.Boolean {
      return _builder.hasJoined()
    }

    /**
     * `.google.protobuf.Timestamp updated = 3 [json_name = "updated"];`
     */
    public var updated: com.google.protobuf.Timestamp
      @JvmName("getUpdated")
      get() = _builder.getUpdated()
      @JvmName("setUpdated")
      set(value) {
        _builder.setUpdated(value)
      }
    /**
     * `.google.protobuf.Timestamp updated = 3 [json_name = "updated"];`
     */
    public fun clearUpdated() {
      _builder.clearUpdated()
    }
    /**
     * `.google.protobuf.Timestamp updated = 3 [json_name = "updated"];`
     * @return Whether the updated field is set.
     */
    public fun hasUpdated(): kotlin.Boolean {
      return _builder.hasUpdated()
    }

    /**
     * `string email = 4 [json_name = "email"];`
     */
    public var email: kotlin.String
      @JvmName("getEmail")
      get() = _builder.getEmail()
      @JvmName("setEmail")
      set(value) {
        _builder.setEmail(value)
      }
    /**
     * `string email = 4 [json_name = "email"];`
     */
    public fun clearEmail() {
      _builder.clearEmail()
    }

    /**
     * `string first_name = 5 [json_name = "firstName"];`
     */
    public var firstName: kotlin.String
      @JvmName("getFirstName")
      get() = _builder.getFirstName()
      @JvmName("setFirstName")
      set(value) {
        _builder.setFirstName(value)
      }
    /**
     * `string first_name = 5 [json_name = "firstName"];`
     */
    public fun clearFirstName() {
      _builder.clearFirstName()
    }

    /**
     * `string last_name = 6 [json_name = "lastName"];`
     */
    public var lastName: kotlin.String
      @JvmName("getLastName")
      get() = _builder.getLastName()
      @JvmName("setLastName")
      set(value) {
        _builder.setLastName(value)
      }
    /**
     * `string last_name = 6 [json_name = "lastName"];`
     */
    public fun clearLastName() {
      _builder.clearLastName()
    }

    /**
     * `.api.v1.School school = 7 [json_name = "school"];`
     */
    public var school: lol.calico.uctutors.generated.api.v1.School
      @JvmName("getSchool")
      get() = _builder.getSchool()
      @JvmName("setSchool")
      set(value) {
        _builder.setSchool(value)
      }
    public var schoolValue: kotlin.Int
      @JvmName("getSchoolValue")
      get() = _builder.getSchoolValue()
      @JvmName("setSchoolValue")
      set(value) {
        _builder.setSchoolValue(value)
      }
    /**
     * `.api.v1.School school = 7 [json_name = "school"];`
     */
    public fun clearSchool() {
      _builder.clearSchool()
    }

    /**
     * `uint32 class_of = 8 [json_name = "classOf"];`
     */
    public var classOf: kotlin.Int
      @JvmName("getClassOf")
      get() = _builder.getClassOf()
      @JvmName("setClassOf")
      set(value) {
        _builder.setClassOf(value)
      }
    /**
     * `uint32 class_of = 8 [json_name = "classOf"];`
     */
    public fun clearClassOf() {
      _builder.clearClassOf()
    }

    /**
     * `string bio = 9 [json_name = "bio"];`
     */
    public var bio: kotlin.String
      @JvmName("getBio")
      get() = _builder.getBio()
      @JvmName("setBio")
      set(value) {
        _builder.setBio(value)
      }
    /**
     * `string bio = 9 [json_name = "bio"];`
     */
    public fun clearBio() {
      _builder.clearBio()
    }

    /**
     * `string avatar_id = 10 [json_name = "avatarId"];`
     */
    public var avatarId: kotlin.String
      @JvmName("getAvatarId")
      get() = _builder.getAvatarId()
      @JvmName("setAvatarId")
      set(value) {
        _builder.setAvatarId(value)
      }
    /**
     * `string avatar_id = 10 [json_name = "avatarId"];`
     */
    public fun clearAvatarId() {
      _builder.clearAvatarId()
    }

    /**
     * `string banner_id = 11 [json_name = "bannerId"];`
     */
    public var bannerId: kotlin.String
      @JvmName("getBannerId")
      get() = _builder.getBannerId()
      @JvmName("setBannerId")
      set(value) {
        _builder.setBannerId(value)
      }
    /**
     * `string banner_id = 11 [json_name = "bannerId"];`
     */
    public fun clearBannerId() {
      _builder.clearBannerId()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class CampusAvailabilityProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     */
     public val campusAvailability: com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getCampusAvailabilityList()
      )
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     * @param value The campusAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addCampusAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.add(value: lol.calico.uctutors.generated.api.v1.CampusAvailability) {
      _builder.addCampusAvailability(value)
    }
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     * @param value The campusAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignCampusAvailability")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.plusAssign(value: lol.calico.uctutors.generated.api.v1.CampusAvailability) {
      add(value)
    }
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     * @param values The campusAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllCampusAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.addAll(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.CampusAvailability>) {
      _builder.addAllCampusAvailability(values)
    }
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     * @param values The campusAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllCampusAvailability")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.plusAssign(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.CampusAvailability>) {
      addAll(values)
    }
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     * @param index The index to set the value at.
     * @param value The campusAvailability to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setCampusAvailability")
    public operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.set(index: kotlin.Int, value: lol.calico.uctutors.generated.api.v1.CampusAvailability) {
      _builder.setCampusAvailability(index, value)
    }
    /**
     * `repeated .api.v1.CampusAvailability campus_availability = 12 [json_name = "campusAvailability"];`
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearCampusAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.CampusAvailability, CampusAvailabilityProxy>.clear() {
      _builder.clearCampusAvailability()
    }


    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class VirtualAvailabilityProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     */
     public val virtualAvailability: com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getVirtualAvailabilityList()
      )
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     * @param value The virtualAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addVirtualAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.add(value: lol.calico.uctutors.generated.api.v1.VirtualAvailability) {
      _builder.addVirtualAvailability(value)
    }
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     * @param value The virtualAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignVirtualAvailability")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.plusAssign(value: lol.calico.uctutors.generated.api.v1.VirtualAvailability) {
      add(value)
    }
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     * @param values The virtualAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllVirtualAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.addAll(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.VirtualAvailability>) {
      _builder.addAllVirtualAvailability(values)
    }
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     * @param values The virtualAvailability to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllVirtualAvailability")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.plusAssign(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.VirtualAvailability>) {
      addAll(values)
    }
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     * @param index The index to set the value at.
     * @param value The virtualAvailability to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setVirtualAvailability")
    public operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.set(index: kotlin.Int, value: lol.calico.uctutors.generated.api.v1.VirtualAvailability) {
      _builder.setVirtualAvailability(index, value)
    }
    /**
     * `repeated .api.v1.VirtualAvailability virtual_availability = 13 [json_name = "virtualAvailability"];`
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearVirtualAvailability")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.VirtualAvailability, VirtualAvailabilityProxy>.clear() {
      _builder.clearVirtualAvailability()
    }


    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class TopicsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @return A list containing the topics.
     */
    public val topics: com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getTopicsList()
      )
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @param value The topics to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addTopics")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.add(value: kotlin.String) {
      _builder.addTopics(value)
    }
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @param value The topics to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignTopics")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @param values The topics to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllTopics")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllTopics(values)
    }
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @param values The topics to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllTopics")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * `repeated string topics = 14 [json_name = "topics"];`
     * @param index The index to set the value at.
     * @param value The topics to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setTopics")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setTopics(index, value)
    }/**
     * `repeated string topics = 14 [json_name = "topics"];`
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearTopics")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, TopicsProxy>.clear() {
      _builder.clearTopics()
    }
    /**
     * `uint32 tutor_score = 15 [json_name = "tutorScore"];`
     */
    public var tutorScore: kotlin.Int
      @JvmName("getTutorScore")
      get() = _builder.getTutorScore()
      @JvmName("setTutorScore")
      set(value) {
        _builder.setTutorScore(value)
      }
    /**
     * `uint32 tutor_score = 15 [json_name = "tutorScore"];`
     */
    public fun clearTutorScore() {
      _builder.clearTutorScore()
    }

    /**
     * `uint32 tutee_score = 16 [json_name = "tuteeScore"];`
     */
    public var tuteeScore: kotlin.Int
      @JvmName("getTuteeScore")
      get() = _builder.getTuteeScore()
      @JvmName("setTuteeScore")
      set(value) {
        _builder.setTuteeScore(value)
      }
    /**
     * `uint32 tutee_score = 16 [json_name = "tuteeScore"];`
     */
    public fun clearTuteeScore() {
      _builder.clearTuteeScore()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class ExperiencesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     */
     public val experiences: com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getExperiencesList()
      )
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     * @param value The experiences to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addExperiences")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.add(value: lol.calico.uctutors.generated.api.v1.Experience) {
      _builder.addExperiences(value)
    }
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     * @param value The experiences to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignExperiences")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.plusAssign(value: lol.calico.uctutors.generated.api.v1.Experience) {
      add(value)
    }
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     * @param values The experiences to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllExperiences")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.addAll(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.Experience>) {
      _builder.addAllExperiences(values)
    }
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     * @param values The experiences to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllExperiences")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.plusAssign(values: kotlin.collections.Iterable<lol.calico.uctutors.generated.api.v1.Experience>) {
      addAll(values)
    }
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     * @param index The index to set the value at.
     * @param value The experiences to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setExperiences")
    public operator fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.set(index: kotlin.Int, value: lol.calico.uctutors.generated.api.v1.Experience) {
      _builder.setExperiences(index, value)
    }
    /**
     * `repeated .api.v1.Experience experiences = 17 [json_name = "experiences"];`
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearExperiences")
    public fun com.google.protobuf.kotlin.DslList<lol.calico.uctutors.generated.api.v1.Experience, ExperiencesProxy>.clear() {
      _builder.clearExperiences()
    }

  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.User.copy(block: `lol.calico.uctutors.generated.api.v1`.UserKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.User =
  `lol.calico.uctutors.generated.api.v1`.UserKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val lol.calico.uctutors.generated.api.v1.UserOrBuilder.joinedOrNull: com.google.protobuf.Timestamp?
  get() = if (hasJoined()) getJoined() else null

public val lol.calico.uctutors.generated.api.v1.UserOrBuilder.updatedOrNull: com.google.protobuf.Timestamp?
  get() = if (hasUpdated()) getUpdated() else null

