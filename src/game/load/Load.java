/**
 *
 */
package game.load;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class Load {

	private Cell[][] maze;

	public Cell[][] load (String path) throws XMLStreamException, FileNotFoundException {
		String[] p = path.split("\\.");
		if (!p[1].equalsIgnoreCase("xml")) {
			return null;
		}
		ISetClassesAttributes classAttributes;
		IStrategyFactory strategyFactory = new StrategyFactory();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
        		factory.createXMLEventReader(new FileReader(path));

        while (eventReader.hasNext()) {
        	XMLEvent event = eventReader.nextEvent();
        	switch (event.getEventType()) {
        		case XMLStreamConstants.START_ELEMENT:
        			StartElement startElement = event.asStartElement();
        			String className = startElement.getName().getLocalPart();
        			if (className.equalsIgnoreCase("Cell")) {
        				Map<String, Object> map = new HashMap<String, Object>();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                        	Attribute t = attributes.next();
                            map.put(t.getName().toString(), t.getValue());
                        }
                        int row = Integer.parseInt(map.get("ROW").toString());
                        int col = Integer.parseInt(map.get("COLUMN").toString());
                        maze = new Cell[row][col];

        			} else if (!className.equalsIgnoreCase("Maze")){
        				Map<String, Object> map = new HashMap<String, Object>();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                        	Attribute t = attributes.next();
                            map.put(t.getName().toString(), t.getValue());
                        }
                        classAttributes = strategyFactory.getStrategy(className);
                        classAttributes.setClassAttributes(maze, map);
        			}
                    break;
                }
            }

		return maze;
	}
}
