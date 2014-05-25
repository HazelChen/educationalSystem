<?xml version="1.0" encoding="UTF-8"?>
<xsl:stysheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8">
	<xsl:template match="Choices">
	 <xsl:apply-templates/>
		<Choices>
			<xsl:for-each select="choice">
				<choice>
					<xsl:choose>
						<xsl:when test="A">
							<sid>
								<xsl:value-of select="学生编号"/>
							</sid>
							<cid>
								<xsl:value-of select="课程编号"/>
							</cid>
							<score>
								<xsl:value-of select="得分"/>
							</score>
						</xsl:when>
						<xsl:when test="B">
							<sid>
								<xsl:value-of select="学号"/>
							</sid>
							<cid>
								<xsl:value-of select="课程编号"/>
							</cid>
							<score>
								<xsl:value-of select="成绩"/>
							</score>
						</xsl:when>
						<xsl:when test="C">
							<sid>
								<xsl:value-of select="Sno"/>
							</sid>
							<cid>
								<xsl:value-of select="Cno"/>
							</cid>
							<score>
								<xsl:value-of select="Grd"/>
							</score>
						</xsl:when>
					</xsl:choose>
				</choice>
			</xsl:for-each>
		</Choices>
</xsl:template>
</xsl:output>
</xsl:stysheet>