import sbt._

class MainProject(info: ProjectInfo) extends AndroidProject(info) {
  val androidPlatformName = "android-10"
  override val skipProguard = true
}
