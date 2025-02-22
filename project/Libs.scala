import sbt._

object Libs {
  val ScalaVersion = "2.13.3"

  val `scalaTest`         = "org.scalatest"                            %% "scalatest"         % "3.1.4" //Apache License 2.0
  val `selenium-java`     = "org.seleniumhq.selenium"                   % "selenium-java"     % "3.141.59"
  val `embedded-keycloak` = "com.github.tmtsoftware.embedded-keycloak" %% "embedded-keycloak" % "0.2.0"
  val `webdriverManager`  = "io.github.bonigarcia"                      % "webdrivermanager"  % "4.2.2"
  val `tmt-test-reporter` = "com.github.tmtsoftware"                   %% "rtm"               % "fecc848abf7"
  val scalaTestPlus       = "org.scalatestplus"                        %% "selenium-3-141"    % "3.2.2.0"
}

object ESW {
  val Version: String = {
    sys.props.get("prod.publish") match {
      case Some("true") => {
        val env = sys.env ++ sys.props
        env.getOrElse("ESW_VERSION", "754b6e337e")
      }
      case _ => "0.1.0-SNAPSHOT"
    }
  }
}

object CSW {
  val Version: String = {
    sys.props.get("prod.publish") match {
      case Some("true") => {
        val env = sys.env ++ sys.props
        env.getOrElse("CSW_VERSION", "efe5d22c46")
      }
      case _ => "0.1.0-SNAPSHOT"
    }
  }

  val `csw-location-server` = "com.github.tmtsoftware.csw" %% "csw-location-server" % Version
  val `csw-config-server`   = "com.github.tmtsoftware.csw" %% "csw-config-server"   % Version
}
