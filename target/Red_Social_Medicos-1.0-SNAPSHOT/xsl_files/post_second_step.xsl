<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
            <tr>
                <td colspan="3">
                    <h2><xsl:value-of select="screen/title"></xsl:value-of></h2>
                </td>
            </tr>
            <tr><td colspan="3"><p><xsl:value-of select="screen/description"></xsl:value-of></p></td></tr>
    </xsl:template>
</xsl:stylesheet>