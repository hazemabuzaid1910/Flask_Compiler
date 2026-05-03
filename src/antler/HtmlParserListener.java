// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/HtmlParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HtmlParser}.
 */
public interface HtmlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HtmlParser#htmlNode}.
	 * @param ctx the parse tree
	 */
	void enterHtmlNode(HtmlParser.HtmlNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#htmlNode}.
	 * @param ctx the parse tree
	 */
	void exitHtmlNode(HtmlParser.HtmlNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(HtmlParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(HtmlParser.HtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlPairTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlPairTagExp(HtmlParser.HtmlPairTagExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlPairTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlPairTagExp(HtmlParser.HtmlPairTagExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlSingleTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSingleTagExp(HtmlParser.HtmlSingleTagExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlSingleTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSingleTagExp(HtmlParser.HtmlSingleTagExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#htmlPairTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlPairTag(HtmlParser.HtmlPairTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#htmlPairTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlPairTag(HtmlParser.HtmlPairTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlSingleTagSelfClosing}
	 * labeled alternative in {@link HtmlParser#htmlSingleTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlSingleTagSelfClosing(HtmlParser.HtmlSingleTagSelfClosingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlSingleTagSelfClosing}
	 * labeled alternative in {@link HtmlParser#htmlSingleTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlSingleTagSelfClosing(HtmlParser.HtmlSingleTagSelfClosingContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(HtmlParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(HtmlParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttribute(HtmlParser.HtmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttribute(HtmlParser.HtmlAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#attributeKey}.
	 * @param ctx the parse tree
	 */
	void enterAttributeKey(HtmlParser.AttributeKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#attributeKey}.
	 * @param ctx the parse tree
	 */
	void exitAttributeKey(HtmlParser.AttributeKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(HtmlParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(HtmlParser.AttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElementHtml}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterElementHtml(HtmlParser.ElementHtmlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElementHtml}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitElementHtml(HtmlParser.ElementHtmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterStatementJinja(HtmlParser.StatementJinjaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitStatementJinja(HtmlParser.StatementJinjaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterExpressionJinja(HtmlParser.ExpressionJinjaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitExpressionJinja(HtmlParser.ExpressionJinjaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssClassExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterCssClassExpression(HtmlParser.CssClassExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssClassExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitCssClassExpression(HtmlParser.CssClassExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterTextExpression(HtmlParser.TextExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitTextExpression(HtmlParser.TextExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(HtmlParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(HtmlParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(HtmlParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(HtmlParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssClass}.
	 * @param ctx the parse tree
	 */
	void enterCssClass(HtmlParser.CssClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssClass}.
	 * @param ctx the parse tree
	 */
	void exitCssClass(HtmlParser.CssClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssKey}.
	 * @param ctx the parse tree
	 */
	void enterCssKey(HtmlParser.CssKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssKey}.
	 * @param ctx the parse tree
	 */
	void exitCssKey(HtmlParser.CssKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(HtmlParser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(HtmlParser.CssValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(HtmlParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(HtmlParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(HtmlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(HtmlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpression(HtmlParser.JinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpression(HtmlParser.JinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void enterForBlock(HtmlParser.ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void exitForBlock(HtmlParser.ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(HtmlParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(HtmlParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(HtmlParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(HtmlParser.TextContext ctx);
}