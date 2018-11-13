<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:variable name="RESULTS" select="rolodex/BusinessCard" />
    <xsl:variable name="RESULTS_COUNT" select="count($RESULTS)" />
    <xsl:template match="/">
        <html style="font-family: monospace; color: white; background: black;">
            <body>
                <h1>
                        Rolodex
                        <xsl:value-of select="company" />
                </h1>
                <xsl:for-each select="rolodex/BusinessCard">
                    <table border="1" border-style="solid">
                        <tr>
                            <td>Name</td>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                        </tr>
                        <tr>
                            <td>Company</td>
                            <td>
                                <xsl:value-of select="company" />
                            </td>
                        </tr>
                    </table>
                    <br />
                </xsl:for-each>
                <br />
                <h3>
                        Stored Business Cards:
                        <xsl:value-of select="$RESULTS_COUNT" />
                </h3>
                <ol>
                    <xsl:for-each select="$RESULTS">
                        <li>
                            <xsl:value-of select="name" />
                        </li>
                    </xsl:for-each>
                </ol>
                <xsl:variable name="OG_RESULTS" select="rolodex/BusinessCard" />
                <h4>
                        OG Business Cards:
                        <xsl:value-of select="count($OG_RESULTS)" />
                </h4>
                <ol>
                    <xsl:for-each select="$RESULTS">
                        <li>
                            <xsl:value-of select="name" />
                        </li>
                    </xsl:for-each>
                </ol>
                <h4>
                        Clone Business Cards:
                        <xsl:value-of select="count($RESULTS/name[contains(.,'Clone')])" />
                </h4>
                <ol>
                    <xsl:for-each select="$RESULTS">
                        <xsl:variable name="person-name" select="name" />
                        <xsl:if test="contains($person-name ,'lone')">
                            <li>
                                <xsl:value-of select="$person-name" />
                            </li>
                        </xsl:if>
                    </xsl:for-each>
                </ol>
                <h4>
                        Clone Business Cards (Second Crack):
                        <xsl:value-of select="count($RESULTS/name[contains(.,'Clone')])" />
                </h4>
                <ol>
                    <xsl:for-each select="$RESULTS/name[contains(.,'Clone')]">
                        <xsl:variable name="person-name" select="name" />
                        <li>
                            <xsl:value-of select="." />
                        </li>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>