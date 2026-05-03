// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/HtmlParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HtmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HtmlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HtmlParser#htmlNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlNode(HtmlParser.HtmlNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(HtmlParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlPairTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlPairTagExp(HtmlParser.HtmlPairTagExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlSingleTagExp}
	 * labeled alternative in {@link HtmlParser#htmlTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlSingleTagExp(HtmlParser.HtmlSingleTagExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#htmlPairTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlPairTag(HtmlParser.HtmlPairTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlSingleTagSelfClosing}
	 * labeled alternative in {@link HtmlParser#htmlSingleTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlSingleTagSelfClosing(HtmlParser.HtmlSingleTagSelfClosingContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(HtmlParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(HtmlParser.HtmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#attributeKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeKey(HtmlParser.AttributeKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(HtmlParser.AttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementHtml}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementHtml(HtmlParser.ElementHtmlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementJinja(HtmlParser.StatementJinjaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionJinja}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionJinja(HtmlParser.ExpressionJinjaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssClassExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssClassExpression(HtmlParser.CssClassExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextExpression(HtmlParser.TextExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(HtmlParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(HtmlParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssClass(HtmlParser.CssClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssKey(HtmlParser.CssKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(HtmlParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(HtmlParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(HtmlParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpression(HtmlParser.JinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#forBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBlock(HtmlParser.ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(HtmlParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(HtmlParser.TextContext ctx);
}