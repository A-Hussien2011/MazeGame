/**
 *
 */
package game.save;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerConfigurationException;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class Save {

	private Cell[][] maze;
	public Save (Cell[][] maze) {
		this.maze = maze;
	}


	public void saveMaze(String path) throws TransformerConfigurationException {


		XMLStreamWriter xMLStreamWriter = null;
		FileOutputStream fileOutputStream = null;
		try {
            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            fileOutputStream = new FileOutputStream(path+".xml");
            xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(fileOutputStream, "ISO-8859-1");
            xMLStreamWriter = new IndentingXMLStreamWriter(xMLStreamWriter);
            xMLStreamWriter.writeStartDocument();
		} catch (Exception e) {
			//add log error
		}
		try {
			xMLStreamWriter.writeStartElement("Maze");
			xMLStreamWriter.writeStartElement("Cell");
			xMLStreamWriter.writeAttribute("ROW", String.valueOf(maze.length));
			xMLStreamWriter.writeAttribute("COLUMN", String.valueOf(maze.length));
			xMLStreamWriter.writeEndElement();
		} catch (XMLStreamException e2) {
			//add log
		}

		ISetAttributes attributes;
		IStrategyFactory strategyFactory = new StrategyFactory();
		IHashCellFactory factory = new HashCellFactory();
        for (int i = 0; i < maze.length; i++) {
        	for (int j = 0; j < maze.length; j++) {
        		try {
        			String className = maze[i][j].getClassName();
					xMLStreamWriter.writeStartElement(className);
					attributes = strategyFactory.getStrategy(className);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("ROW", i);
					map.put("COLUMN", j);
					map.put("MAZE", maze[i][j]);
					map.put("TYPE", factory.getClassHashCode(className));
					attributes.addAttribute(xMLStreamWriter, map);
					xMLStreamWriter.writeEndElement();
				} catch (XMLStreamException e1) {
					e1.printStackTrace();
				}
        	}
        }

        try {
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeEndDocument();
			xMLStreamWriter.flush();
	        xMLStreamWriter.close();
	        fileOutputStream.flush();
	        fileOutputStream.close();
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}

	}

}
