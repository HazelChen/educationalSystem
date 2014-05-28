<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/courses">
	<courses>
		<xsl:for-each select="course">
			<course>
				<Cno>
					<xsl:value-of select="id"/>
				</Cno>
				<Cnm>
					<xsl:value-of select="name"/>
				</Cnm>
				<Ctm>
					<xsl:value-of select="time"/>
				</Ctm>
				<Cpt>
					<xsl:value-of select="score"/>
				</Cpt>
				<Tec>
					<xsl:value-of select="teacher"/>
				</Tec>
				<Pla>
					<xsl:value-of select="location"/>
				</Pla>
				<Share>1</Share>
			</course>
		</xsl:for-each>
	</courses>	
	</xsl:template>
</xsl:stylesheet>