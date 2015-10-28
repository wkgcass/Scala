package net.cassite.daf4j

import net.cassite.daf4j.util.Selectable

/**
 * 增强的Focus
 * @param focus Focus对象
 */
class RichFocus(private[daf4j] val focus: Focus) {
  def +(pair: (Selectable, String)) = focus.focus(pair._1, pair._2)

  def +(d: IData[_]) = focus.focus(d)
}
