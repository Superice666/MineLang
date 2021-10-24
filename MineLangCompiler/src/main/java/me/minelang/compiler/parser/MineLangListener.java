// Generated from D:/MineLang/MineLangCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MineLangParser}.
 */
public interface MineLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MineLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MineLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MineLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void enterCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void exitCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varSetExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarSetExpr(MineLangParser.VarSetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varSetExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarSetExpr(MineLangParser.VarSetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfelseExpr(MineLangParser.IfelseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfelseExpr(MineLangParser.IfelseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mutiplyDevideRemainExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMutiplyDevideRemainExpr(MineLangParser.MutiplyDevideRemainExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mutiplyDevideRemainExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMutiplyDevideRemainExpr(MineLangParser.MutiplyDevideRemainExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketExpr(MineLangParser.BracketExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketExpr(MineLangParser.BracketExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(MineLangParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(MineLangParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBreakExpr(MineLangParser.BreakExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBreakExpr(MineLangParser.BreakExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MineLangParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MineLangParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isEqExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsEqExpr(MineLangParser.IsEqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isEqExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsEqExpr(MineLangParser.IsEqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGetExpr(MineLangParser.GetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGetExpr(MineLangParser.GetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(MineLangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(MineLangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code endlessLoopExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEndlessLoopExpr(MineLangParser.EndlessLoopExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code endlessLoopExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEndlessLoopExpr(MineLangParser.EndlessLoopExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(MineLangParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(MineLangParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(MineLangParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(MineLangParser.CompareExprContext ctx);
}