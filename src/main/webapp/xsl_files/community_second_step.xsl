<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="screen">
        <li><table><xsl:apply-templates/></table></li>
    </xsl:template>
    <xsl:template match="field">
        <tr><th><xsl:value-of select = "@label"/></th></tr>
        <tr><td><xsl:apply-templates/></td></tr>
    </xsl:template>
</xsl:stylesheet>