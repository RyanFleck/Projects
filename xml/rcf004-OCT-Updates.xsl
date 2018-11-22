<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html style="font-family: sans-serif;">
            <body>
                <h1>
                        OCT DATA:
                        XML &amp; XSLT TEST
                </h1>
                <hr />
                <h2>DETOURS:</h2>
                <xsl:for-each select="rss/channel/item[contains(title,'DETOUR')]">
                    <h3>
                        <xsl:value-of select="title" />
                    </h3>
                    <p>
                        <xsl:value-of select="pubDate" />
                    </p>
                </xsl:for-each>
                <!--xsl:value-of disable-output-escaping="yes" select="rss/channel/item/description" /-->
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>