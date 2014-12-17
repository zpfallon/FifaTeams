package com.wm.zpfallon.fifateams;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by zpfallon on 12/16/14.
 * Parse the team.xml resource
 */
public class TeamXmlParser {

    public ArrayList<Team> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser parser = xmlFactoryObject.newPullParser();
            parser.setInput(in,null);
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    private ArrayList<Team> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException{
        ArrayList<Team> entries = new ArrayList<>();
        Team currentTeam = new Team();
        int event = parser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT)
        {
            String name = parser.getName();
            switch (event){
                case XmlPullParser.START_TAG:
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals("entry")) {
                        currentTeam.setName(parser.getAttributeValue(null, "name"));
                        currentTeam.setAtt(parser.getAttributeValue(null, "att"));
                        currentTeam.setMid(parser.getAttributeValue(null, "mid"));
                        currentTeam.setDef(parser.getAttributeValue(null, "def"));
                        entries.add(currentTeam);
                        currentTeam = new Team();
                    }
                    break;
            }
            event = parser.next();
        }
        return entries;
    }
}
