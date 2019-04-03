# XMLSaxParser

Parsing the XML file using SAXParser.

I've given the local file path as input to the Parser along with the handler.

As I am using the SAXParser, it parses the XML file node and node.

I've set conditions based on the corresponding tags to get the corresponding objects from the XML file.

If the user gives the unformatted XML file, the handler file throws the SAXException which is then handled in the Parser class giving the cause for the exception.


Sample XML File I've considered for parsing:

<?xml version="1.0" encoding="UTF-8"?>
<contacts>
   <contact id="1">
      <name>Jacob</name>
      <lastName>Ackerman</lastName>
      <contacts>
         <contact id="2">
            <name>Clara</name>
            <lastName>JANE</lastName>
            <contacts />
         </contact>
      </contacts>
   </contact>
   <contact id="3">
      <name>Jake</name>
      <lastName>DOE</lastName>
   </contact>
</contacts>
