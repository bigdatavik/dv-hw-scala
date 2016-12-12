name := "dv-hw-scala"
version := "1.0"
organization := "dv.hw"
scalaVersion := "2.10.4"



assemblyMergeStrategy in assembly := {

  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  //case PathList("scala", xs @ _*)                    => MergeStrategy.discard

  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

// This line is critical for portability within IBM DSX Jupyter notebooks
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
