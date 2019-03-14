# Programming in XML

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/xml](https://ryanfleck.github.io/xml)
  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Oh>
    <My>
        <XML what="XML">Hello XML &amp; XSLT!</XML>
    </My>
</Oh>
```

<br />


<br />

# XML

## What is XML?

**eXtensible Markup Language**, like JSON or YAML, is a file format for stucturing documents containing nested key-value data. But, where JSON is just a data format, XML has many other powerful features that make it more suitable for complex documents. Blocks of data can also store additional metadata, xPath and XSL enable for easy document querying and modification,

_Why does a markup language have its own manual?_ The complex systems built around XML warrant a unique umbrella page.

XML can be maniuplated in all popular programming languages, and like json, enables systems built with different data stores and languages to share objects.

## When To Use XML
- JSON isn't good enough.
- Larger documents that need more complex data.
- More documents will need to be created, which need to adhere to a schema.

## When Not To Use XML
- Very large datasets `=>` use a database.
- Small/simple document `=>` use JSON.
- Not all data types can be easily expressed in XML.
- If people have to read your document.
- If your language has a better 'native' document format (Node.JS has JSON).

## A Simple XML Document

```xml
<?xml version="1.0" encoding="UTF-8"?>
<BusinessCard>
    <name>Ryan Fleck</name>
    <company>MNP LLP</company>
    <email>ryan.fleck@protonmail.com</email>
</BusinessCard>
```

An XML Document can include:

Name | Example
-----|--------------------------------------------------
Document Declaration | `<?xml version="1.0" encoding="UTF-8" standalone="yes"?>`
Elements/Attributes | `<element attribute="value">Element Value</element>`
Comments | `<!-- Oh, it's like an HTML comment. -->`
Character Data | `<![CDATA[Text to parse]]>`
Processing Instructions | `<?CurrencyBase mode="USD"?>`
Entity References | `This is a string that is (&copy;)2018`





## XML Syntax

Essentially, XML expresses data with *elements*:
```xml
<element attr-one="value" attr-two="another">Content</element>
```
Elements have tags, attributes and content. If the content is complex, it can be stored as *character data* by using a `<![CDATA[ content ]]>` statement as the content of an element.

## Validating XML Documents

## Namespaces

## Styling

Point to a `.css` file so the XML can be rendered in a browser:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/css" href="bizcard.css"?>
<rolodex>
    <BusinessCard>
        <name>Ryan Fleck</name>
        <company>Unaffiliated</company>
        <position>Consulting Developer</position>
        <email type="work">ryan.fleck@protonmail.com</email>
    </BusinessCard>

    <BusinessCard>
        <name>Clone of Ryan Fleck 12</name>
        <company>MNP LLP</company>
        <position>Co-Op Developer</position>
        <email type="work">ryan.fleck@protonmail.com</email>
    </BusinessCard>

    <BusinessCard>
        <name>Clone of Ryan Fleck 13</name>
        <company>Starbucks Coffee</company>
        <position>Barista</position>
        <email type="work">ryan.fleck@protonmail.com</email>
    </BusinessCard>

        <BusinessCard>
        <name>Clone of Ryan Fleck 22</name>
        <company>Unaffiliated</company>
        <position>Consulting Analyst</position>
        <email type="work">ryan.fleck@protonmail.com</email>
    </BusinessCard>
</rolodex>
```

```css
rolodex{
    padding: 1em;
}

BusinessCard {
    background: #444;
    text-align: left;
    border: 1px solid gold;
    color: gold;
    margin: 1em;
    padding: 1em;
    display: block;
    min-width: 100px;
    max-width: 300px;
}

name, company, position, email {
    color: gold;
    display: block;
}

name {
    font-size: 1.3em;
}

position {
    font-size: 0.8em;
}
```

# XPath

XPath, **eXtensible Path Language**, is used for quickly gathering single/lists of nodes from an XML document. It could be described as a language for defining *subsets* of an XML document. Here is part of an XML document that will serve as an example throughout the remainder of this section:
```xml
<rss version="2.0">
    <channel>
        <title>OC Transpo - Live Updates</title>
        <link>http://www.octranspo.com/</link>
        <description>
Daily route changes resulting from detours and cancelled trips are listed here by OC Transpo staff on weekdays, Saturdays until 9 pm and Sundays until 5 pm.
        </description>
        <atom:link href="http://octranspo1.com/feeds/updates-en" rel="self" type="application/rss+xml"/>
        <item urgent="urgent">
            <title>DETOUR: Chapel Crescent Closure (Mann to Lees)</title>
            <pubDate>Mon, 15 Oct 2018 14:51:00 EDT</pubDate>
            <category>
                <![CDATA[ Detours ]]>
            </category>
            <category>
                <![CDATA[ affectedRoutes-16,85 ]]>
            </category>
            <link>http://octranspo1.com/update-details/215294</link>
            <description>
            <![CDATA[ October 15 2018 - <p> From <strong>9am to ...shortened... </em></a></p>]]>
            </description>
            <guid>http://octranspo1.com/update-details/215294</guid>
        </item>
        <item>
            <title>DETOUR: Piperville Road Closure</title>
            <pubDate>Wed, 03 Oct 2018 09:43:00 EDT</pubDate>
            <!-- More data... -->
        </item>
        <!-- Many more items... -->
    </channel>
</rss>
```
If I were programming a service that processes each update item, I would want to grab both the content of elements, and any useful attributes.

Basic XPATH functions are as follows:
- Grab all *item* elements in the rss feed: `//rss/channel/item`.
- Grab the first *item* element: `//rss/channel/item[1]`.
- Grab the last *item* element: `//rss/channel/item[last()]`.
- Grab all *item* elements: `//item`.
- Grab all items with *urgent* attribute: `//title[@urgent]`.

# XSLT

XSLT, **XML Stylesheet Language Transformations**, are like CSS for XML. You can still use CSS to style XML, but XSL is... also something you can use.

# DTD & XML Schema




# XQuery

Not studied yet.

# Xpointer

Not studied yet.

# XLink

Not studied yet.

# Resources

1. IBM XSLT Intro <https://www.ibm.com/developerworks/xml/tutorials/x-introxslt/x-introxslt.html>
