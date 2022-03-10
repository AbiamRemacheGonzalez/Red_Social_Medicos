<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <table>
            <tr>
                <td><h2><xsl:value-of select="screen/name"></xsl:value-of></h2></td>
            </tr>
        </table>
        <br></br>
    </xsl:template>
</xsl:stylesheet>