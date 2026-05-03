// Generated from C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/src/antler/FlaskParser.g4 by ANTLR 4.13.2
package antler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskParser}.
 */
public interface FlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtFunction}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtFunction(FlaskParser.StmtFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtFunction}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtFunction(FlaskParser.StmtFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtIf(FlaskParser.StmtIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtIf(FlaskParser.StmtIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtFor}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtFor(FlaskParser.StmtForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtFor}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtFor(FlaskParser.StmtForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtWith}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtWith(FlaskParser.StmtWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtWith}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtWith(FlaskParser.StmtWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtDecorator}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtDecorator(FlaskParser.StmtDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtDecorator}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtDecorator(FlaskParser.StmtDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtImport(FlaskParser.StmtImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtImport}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtImport(FlaskParser.StmtImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtReturn(FlaskParser.StmtReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtReturn(FlaskParser.StmtReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtAssign(FlaskParser.StmtAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtAssign(FlaskParser.StmtAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtExpression}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmtExpression(FlaskParser.StmtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtExpression}
	 * labeled alternative in {@link FlaskParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmtExpression(FlaskParser.StmtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FlaskParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FlaskParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#decoratedFunction}.
	 * @param ctx the parse tree
	 */
	void enterDecoratedFunction(FlaskParser.DecoratedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#decoratedFunction}.
	 * @param ctx the parse tree
	 */
	void exitDecoratedFunction(FlaskParser.DecoratedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(FlaskParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(FlaskParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportSimple}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportSimple(FlaskParser.ImportSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportSimple}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportSimple(FlaskParser.ImportSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportFrom(FlaskParser.ImportFromContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportFrom}
	 * labeled alternative in {@link FlaskParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportFrom(FlaskParser.ImportFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void enterImportAlias(FlaskParser.ImportAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void exitImportAlias(FlaskParser.ImportAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(FlaskParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(FlaskParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(FlaskParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(FlaskParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamIdentifier}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void enterParamIdentifier(FlaskParser.ParamIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamIdentifier}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void exitParamIdentifier(FlaskParser.ParamIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamExpression}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void enterParamExpression(FlaskParser.ParamExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamExpression}
	 * labeled alternative in {@link FlaskParser#parameterFunction}.
	 * @param ctx the parse tree
	 */
	void exitParamExpression(FlaskParser.ParamExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(FlaskParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(FlaskParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(FlaskParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(FlaskParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FlaskParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FlaskParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(FlaskParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(FlaskParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(FlaskParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(FlaskParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(FlaskParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(FlaskParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(FlaskParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(FlaskParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(FlaskParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(FlaskParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(FlaskParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(FlaskParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(FlaskParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(FlaskParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierAtom(FlaskParser.IdentifierAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierAtom(FlaskParser.IdentifierAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterLiteralAtom(FlaskParser.LiteralAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitLiteralAtom(FlaskParser.LiteralAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenAtom(FlaskParser.ParenAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenAtom(FlaskParser.ParenAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterObjectAtom(FlaskParser.ObjectAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitObjectAtom(FlaskParser.ObjectAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterArrayAtom(FlaskParser.ArrayAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitArrayAtom(FlaskParser.ArrayAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListComprehensionAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListComprehensionAtom(FlaskParser.ListComprehensionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListComprehensionAtom}
	 * labeled alternative in {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListComprehensionAtom(FlaskParser.ListComprehensionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(FlaskParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(FlaskParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccess(FlaskParser.IndexAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccess(FlaskParser.IndexAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterCall(FlaskParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link FlaskParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitCall(FlaskParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(FlaskParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(FlaskParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void enterListComprehension(FlaskParser.ListComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void exitListComprehension(FlaskParser.ListComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgExpression}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgExpression(FlaskParser.ArgExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgExpression}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgExpression(FlaskParser.ArgExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgAssignment}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgAssignment(FlaskParser.ArgAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgAssignment}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgAssignment(FlaskParser.ArgAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(FlaskParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(FlaskParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(FlaskParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(FlaskParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(FlaskParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(FlaskParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(FlaskParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(FlaskParser.PairContext ctx);
}