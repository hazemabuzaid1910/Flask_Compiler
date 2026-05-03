// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/FlaskParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtFunction}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtFunction(FlaskParser.StmtFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtIf(FlaskParser.StmtIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtFor}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtFor(FlaskParser.StmtForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtWith}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtWith(FlaskParser.StmtWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtDecorator}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtDecorator(FlaskParser.StmtDecoratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtImport(FlaskParser.StmtImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtReturn(FlaskParser.StmtReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtAssign(FlaskParser.StmtAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtExpression}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExpression(FlaskParser.StmtExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FlaskParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#decoratedFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratedFunction(FlaskParser.DecoratedFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(FlaskParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportSimple}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSimple(FlaskParser.ImportSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFrom(FlaskParser.ImportFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#importAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAlias(FlaskParser.ImportAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(FlaskParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(FlaskParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamIdentifier}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamIdentifier(FlaskParser.ParamIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamExpression}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamExpression(FlaskParser.ParamExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(FlaskParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(FlaskParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FlaskParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FlaskParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#logicalOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(FlaskParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#logicalAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(FlaskParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(FlaskParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(FlaskParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(FlaskParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(FlaskParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierAtom(FlaskParser.IdentifierAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralAtom(FlaskParser.LiteralAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenAtom(FlaskParser.ParenAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAtom(FlaskParser.ObjectAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(FlaskParser.ArrayAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListComprehensionAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehensionAtom(FlaskParser.ListComprehensionAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(FlaskParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(FlaskParser.IndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(FlaskParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FlaskParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(FlaskParser.ListComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgExpression}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgExpression(FlaskParser.ArgExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgAssignment}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgAssignment(FlaskParser.ArgAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(FlaskParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(FlaskParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(FlaskParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(FlaskParser.PairContext ctx);
}