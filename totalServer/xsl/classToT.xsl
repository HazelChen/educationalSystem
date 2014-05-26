<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/courses">
		<courses>
			<xsl:for-each select="course">
				<course>
							<id>
								<xsl:value-of select="编号"/>
								<xsl:value-of select="课程编号"/>
								<xsl:value-of select="Cno"/>
							</id>
							<name>
								<xsl:value-of select="名称"/>
								<xsl:value-of select="课程名称"/>
								<xsl:value-of select="Cnm"/>
							</name>
							<time>
								<xsl:value-of select="课时"/>
								<xsl:value-of select="Ctm"/>
							</time>
							<score>
								<xsl:value-of select="学分"/>
								<xsl:value-of select="Cpt"/>
							</score>
							<teacher>
								<xsl:value-of select="老师"/>
								<xsl:value-of select="授课老师"/>
								<xsl:value-of select="Tec"/>
							</teacher>
							<location>
								<xsl:value-of select="地点"/>
								<xsl:value-of select="授课地点"/>
								<xsl:value-of select="Pla"/>
							</location>						
				</course>
			</xsl:for-each>
		</courses>
</xsl:template>
</xsl:stylesheet>