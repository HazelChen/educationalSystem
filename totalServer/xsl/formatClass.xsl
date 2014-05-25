<?xml version="1.0" encoding="UTF-8"?>
<xsl:stysheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8">
	<xsl:template match="Classes">
	 <xsl:apply-templates/>
		<Classes>
			<xsl:for-each select="class">
				<class>
					<xsl:choose>
						<xsl:when test="A">
							<id>
								<xsl:value-of select="编号"/>
							</id>
							<name>
								<xsl:value-of select="名称"/>
							</name>
							<time>
								<xsl:value-of select="课时"/>
							</time>
							<score>
								<xsl:value-of select="学分"/>
							</score>
							<teacher>
								<xsl:value-of select="老师"/>
							</teacher>
							<location>
								<xsl:value-of select="地点"/>
							</location>
						</xsl:when>
						<xsl:when test="B">
							<id>
								<xsl:value-of select="课程编号"/>
							</id>
							<name>
								<xsl:value-of select="课程名称"/>
							</name>
							
							<score>
								<xsl:value-of select="学分"/>
							</score>
							<teacher>
								<xsl:value-of select="授课老师"/>
							</teacher>
							<location>
								<xsl:value-of select="授课地点"/>
							</location>
						</xsl:when>
						<xsl:when test="C">
							<id>
								<xsl:value-of select="Cno"/>
							</id>
							<name>
								<xsl:value-of select="Cnm"/>
							</name>
							<time>
								<xsl:value-of select="Ctm"/>
							</time>
							<score>
								<xsl:value-of select="Cpt"/>
							</score>
							<teacher>
								<xsl:value-of select="Tec"/>
							</teacher>
							<location>
								<xsl:value-of select="Pla"/>
							</location>
						</xsl:when>
					</xsl:choose>
				</class>
			</xsl:for-each>
		</Classes>
</xsl:template>
</xsl:output>
</xsl:stysheet>