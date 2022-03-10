<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <h1><xsl:value-of select="screen/name"></xsl:value-of> community</h1>
        <p style="color:white;margin-right:160px"><xsl:value-of select="screen/description"></xsl:value-of></p>
        <hr style="color:white;margin-right:160px"></hr>
    </xsl:template>
</xsl:stylesheet>