//book[@year<"2008" and @year>"2000"]


<div class="description">
CSS  .description 
XPath  //div[@class='description']

<div class="white-box">
CSS  .white-box 
XPath  //div[@class = ‘white-box’]

<h3>Portlet Themes Switcher</h3>
CSS  .white-box h3
XPath  //h3[contains(text(),'Portlet Themes Switcher')]

<span>Hop Hey, La la ley</span> - не используя поиск по тексту.
CSS  #i_love_selectors ~span
XPath  //div[@id='i_love_selectors']/following-sibling::span

<span>I'm your father</span> - не используя поиск по тексту.
CSS  .white-box1 span
XPath  //div[@class='i_love_selectors very_match']/preceding-sibling::span

<td>3</td>
CSS  #apulaz td:nth-of-type(3)
XPath  //table[@id='apulaz']//td[3]

<table id="apulaz">
CSS  #apulaz 
XPath  //table[@id='apulaz']
 
