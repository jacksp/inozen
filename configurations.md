# Introduction #

eclipse Mylyn과 Google Code의 Issues Tracker 연동


# Details #

# 다운로드 #

eclipse 에서 Help > Software Updates > Add Site 에 다음의 주소를 추가하고 Mylyn을 설치합니다. (ganymede 기준)

**Mylyn**

**URL :** _http://download.eclipse.org/tools/mylyn/update/e3.4_

**extras**

**URL :** _http://download.eclipse.org/tools/mylyn/update/e3.4/extras_

**incubator**

**URL :** _http://download.eclipse.org/tools/mylyn/update/incubator_

# Mylyn 설치 후 Web Repository 설정 #

순서는 다음과 같습니다.
  * Task Repositories 의 Add Task Repository를 선택 합니다.
![http://inozen.googlecode.com/files/eclipse_mylyn_1.png](http://inozen.googlecode.com/files/eclipse_mylyn_1.png)

  * Add Task Repository 에서 Web Template (Advanced)를 선택 합니다.
![http://inozen.googlecode.com/files/eclipse_mylyn_2.png](http://inozen.googlecode.com/files/eclipse_mylyn_2.png)

  * Next를 선택하고 Web Repository 를 Setting 합니다.
![http://inozen.googlecode.com/files/eclipse_mylyn_3.png](http://inozen.googlecode.com/files/eclipse_mylyn_3.png)

  1. **Server** : http://code.google.com/p/inozen _(google code project home 입니다.)_
  1. **Label** : inozen _(Task Repository Name 입니다.)_
  1. **Anonymous** **Access** 를 uncheck 하세요.
  1. **User** **ID** : 구글 id를 입력하세요.
  1. **Password** : 구글 password를 입력하세요.
  1. **Additional Settings** 의 Advanced Configuration을 설정하세요.
    * **Task** **URL** : `${serverUrl}/issues/detail?id=`
    * **New** **Task** **URL** : `${serverUrl}/issues/entry`
    * **Query** **Request** **URL** : `${serverUrl}/list?can=1&q=&colspec=ID+Type+Status+Priority+Milestone+Owner+Summary&cells=tiles`
    * **Query Pattern** : `<td.+?class="vt col_6".+?onclick="if \(!cancelBubble\) _goIssue\(.+?\)".+?<a.+?href="detail\?id=([0-9]+)">(.+?)</a>.+?</td>`
  1. **Next** 를 선택하여 등록합니다.

  * Task Repositories에 등록된 Web Repository가 보여집니다.
![http://inozen.googlecode.com/files/eclipse_mylyn_4.png](http://inozen.googlecode.com/files/eclipse_mylyn_4.png)

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages