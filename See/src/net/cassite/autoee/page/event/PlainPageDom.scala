package net.cassite.autoee.page.event

import net.cassite.autoee.page.dom.Plain

/**
 * @author wkgcass
 */
class PlainPageDom(val text: String, parent: PageDom) extends PageDom(Plain(text), parent) {
}