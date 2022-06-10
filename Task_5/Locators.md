//book[@year<’2008' and @year>’2000’]


<div class="description">
CSS  .white-box  > .description 
XPath  //div[contains(@class, 'description') and contains(., 'A Liferay portlet')]

<div class="white-box">
CSS  .white-box 
XPath  //div[@class = ‘white-box’]

<h3>Portlet Themes Switcher</h3>
CSS  h3[innertext='Portlet Themes Switcher']
XPath  //h3[contains(text(),'Portlet Themes Switcher')]

<span>Hop Hey, La la ley</span> - не используя поиск по тексту.
CSS  span:nth-child(2)
XPath  .//span[not(following-sibling::*)]

<span>I'm your father</span> - не используя поиск по тексту.
CSS  span:first-child
XPath  .//span[not(preceding-sibling::*)]

<td>3</td>
CSS  td:nth-of-type(3)
XPath  //td[3]

<table id="apulaz">
CSS  #apulaz 
XPath  //table[@id='apulaz']
 
