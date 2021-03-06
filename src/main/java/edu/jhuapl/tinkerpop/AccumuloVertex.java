/* Copyright 2014 The Johns Hopkins University Applied Physics Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.jhuapl.tinkerpop;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.VertexQuery;
import com.tinkerpop.blueprints.util.DefaultVertexQuery;

import edu.jhuapl.tinkerpop.AccumuloGraph.Type;

public class AccumuloVertex extends AccumuloElement implements Vertex {

	AccumuloVertex(AccumuloGraph parent, String id) {
		super(parent, id, Type.Vertex);
	}

	public Iterable<Edge> getEdges(Direction direction, String... labels) {
		return parent.getEdges(id, direction, labels);
	}

	public Iterable<Vertex> getVertices(Direction direction, String... labels) {
		return parent.getVertices(id, direction, labels);
	}

	public VertexQuery query() {
		return new DefaultVertexQuery(this);
	}

	public Edge addEdge(String label, Vertex inVertex) {
		return parent.addEdge(null, this, inVertex, label);
	}

	public void remove() {
		parent.removeVertex(this);
	}

	public String toString() {
		return "[" + getId() + "]";
	}

}
