package gremlin.scala

import org.apache.tinkerpop.gremlin.structure.io.Io
import org.apache.tinkerpop.gremlin.structure.io.IoCore
import org.apache.tinkerpop.gremlin.tinkergraph.structure.{TinkerFactory, TinkerGraph}
import org.scalatest.{Matchers, WordSpec}

class GraphSerialisationSpec extends WordSpec with Matchers {

  "serialising from/to" should {

    "support graphML" in {
      graph.io(IoCore.graphml).writeGraph(file)

      val newGraph = TinkerGraph.open
      newGraph.io(IoCore.graphml).readGraph(file)
      newGraph.V.count.head shouldBe 6
      newGraph.E.count.head shouldBe 6
    }
  }

  def graph = TinkerFactory.createModern
  val file = "target/tinkerpop-modern.xml"
}
