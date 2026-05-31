package Visitor;

import AST.flask.DottedName;
import AST.html.*;
import MainApp.Main;
import antler.FlaskParser;
import antler.HtmlParser;
import antler.HtmlParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.text.html.HTML;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class htmlVisitor extends HtmlParserBaseVisitor {
    @Override
    public HtmlNode visitHtmlNode(HtmlParser.HtmlNodeContext ctx) {
        List<HtmlContent> contents = new ArrayList<>();

        for (HtmlParser.HtmlContentContext content : ctx.htmlContent()) {
            contents.add((HtmlContent) visit(content));
        }

        return new HtmlNode(contents);
    }

    @Override
    public HtmlContent visitElementHtml(HtmlParser.ElementHtmlContext ctx) {
        return visitHtmlElement(ctx.htmlElement());
    }

    @Override
    public HtmlContent visitIdentifierExpression(HtmlParser.IdentifierExpressionContext ctx) {
        return new IdentifierExpression(ctx.getText());
    }

    @Override
    public HtmlContent visitTextExpression(HtmlParser.TextExpressionContext ctx) {
      return (HtmlContent) visitText(ctx.text());
    }

    @Override
    public Text visitText(HtmlParser.TextContext ctx) {
        List<String> rawTexts = new ArrayList<>();
            rawTexts.add(ctx.getText());
        return new Text(rawTexts);
    }

    @Override
    public HtmlContent visitCssClassExpression(HtmlParser.CssClassExpressionContext ctx) {

        List<CssClass> cssClasses = new ArrayList<>();

        for (HtmlParser.CssClassContext cssClassContext : ctx.cssClass()) {
            cssClasses.add(visitCssClass(cssClassContext));
        }

        return new CssClassExpression(cssClasses);
    }

    @Override
    public CssClass visitCssClass(HtmlParser.CssClassContext ctx) {

        List<CssDeclaration> cssDeclarations = new ArrayList<>();

        for (HtmlParser.CssDeclarationContext cssDeclarationContext : ctx.cssDeclaration()) {
            cssDeclarations.add(visitCssDeclaration(cssDeclarationContext));
        }

        return new CssClass(cssDeclarations);
    }

    @Override
    public CssDeclaration visitCssDeclaration(HtmlParser.CssDeclarationContext ctx) {
        CssKey cssKey=visitCssKey(ctx.cssKey());
        List<CssValue> cssValues=new ArrayList<>();
        for (HtmlParser.CssValueContext cssValueContext:ctx.cssValue()){
            cssValues.add(visitCssValue(cssValueContext));
        }


        return new CssDeclaration(cssKey,cssValues);
    }

    @Override
    public CssKey visitCssKey(HtmlParser.CssKeyContext ctx) {
        String key=ctx.getText();
        List<String> rests=new ArrayList<>();
        for (TerminalNode rest :ctx.IDENTIFIER()){
            rests.add(String.valueOf(rest));
        }

        return new CssKey(key,rests);
    }

    @Override
    public CssValue visitCssValue(HtmlParser.CssValueContext ctx) {

        List<String> values = new ArrayList<>();

        values.add(ctx.getText());

        return new CssValue(values);
    }

    @Override
    public HtmlContent visitStatementJinja(HtmlParser.StatementJinjaContext ctx) {
        return (HtmlContent) visit(ctx.jinjaStatement());
    }

    @Override
    public HtmlContent visitExpressionJinja(HtmlParser.ExpressionJinjaContext ctx) {
        JinjaExpression jinjaExpression=visitJinjaExpression(ctx.jinjaExpression());
        return  new ExpressionJinja(jinjaExpression);
    }

    @Override
    public JinjaExpression visitJinjaExpression(HtmlParser.JinjaExpressionContext ctx) {
      DottedName dottedName=visitDottedName(ctx.dottedName());
      return new JinjaExpression(dottedName);
    }

    @Override
    public AST.flask.DottedName visitDottedName(HtmlParser.DottedNameContext ctx) {
        String first=ctx.IDENTIFIER().getFirst().getText();
        List<TerminalNode> ids=ctx.IDENTIFIER();
        List<String> rest = ids.subList(1,ids.size())
                .stream()
                .map(id -> id.getText())
                .toList();
        String fullPath = ctx.getStart()
                .getTokenSource()
                .getSourceName();

        String fileName = Paths.get(fullPath)
                .getFileName()
                .toString();
        boolean exists = Main.semanticError.getE4().exists_E4(first);

        if (exists) {
            // المتغير معرف مسبقاً → لازم نعمل check_E4 (إذا بدك error checking)
            Main.semanticError.getE4().check_E4(first, ctx.getStart().getLine());
        } else {
            // غير معرف → يعتبر Flask variable
            Main.semanticError.getE5().addRequired(fileName, first);
        }

        return new DottedName(first,rest);
    }

    @Override
    public JinjaStatement visitForStatement(HtmlParser.ForStatementContext ctx) {
        return  visitForBlock(ctx.forBlock());
    }

    @Override
    public ForBlock visitForBlock(HtmlParser.ForBlockContext ctx) {
        Main.semanticError.getE4().insert();
        String loopVariable= ctx.IDENTIFIER(0).getText();
        String iterableName=ctx.IDENTIFIER(1).getText();
        Main.semanticError.getE4().add(loopVariable, "loop");

        List<HtmlContent> htmlContents=new ArrayList<>();
        for (HtmlParser.HtmlContentContext htmlContentContext:ctx.htmlContent()){
            htmlContents.add((HtmlContent) visit(htmlContentContext));
        }
        String fullPath = ctx.getStart()
                .getTokenSource()
                .getSourceName();

        String fileName = Paths.get(fullPath)
                .getFileName()
                .toString();
        Main.semanticError.getE5().addRequired(fileName, iterableName);
        Main.semanticError.getE4().get();
        return new ForBlock(loopVariable,iterableName,htmlContents);
    }

    @Override
    public JinjaStatement visitIfStatement(HtmlParser.IfStatementContext ctx) {
        return (JinjaStatement) visitIfBlock(ctx.ifBlock());
    }

    @Override
    public IfBlock visitIfBlock(HtmlParser.IfBlockContext ctx) {
        String ConditionVariable=ctx.getText();
        List<HtmlContent> htmlContents=new ArrayList<>();
        for (HtmlParser.HtmlContentContext htmlContentContext:ctx.htmlContent()){
            htmlContents.add((HtmlContent) visit(htmlContentContext));
        }
        return new IfBlock(ConditionVariable,htmlContents);
    }

    @Override
    public HtmlElement visitHtmlElement(HtmlParser.HtmlElementContext ctx) {
        HtmlTag htmlTag= (HtmlTag) visit(ctx.htmlTag());
        return new HtmlElement(htmlTag);
    }

    @Override
    public HtmlTag visitHtmlPairTagExp(HtmlParser.HtmlPairTagExpContext ctx) {
        return  visitHtmlPairTag(ctx.htmlPairTag());
    }

    @Override
    public HtmlTag visitHtmlSingleTagExp(HtmlParser.HtmlSingleTagExpContext ctx) {
        return (HtmlTag) visit(ctx.htmlSingleTag());
    }

    @Override
    public HtmlPairTag visitHtmlPairTag(HtmlParser.HtmlPairTagContext ctx) {
        TagName tagName = visitTagName(ctx.tagName().get(0));


        List<HtmlAttribute> htmlAttributes = new ArrayList<>();
        Main.semanticError.getE1().insert(ctx.tagName().get(0).getText());

        for (HtmlParser.HtmlAttributeContext htmlAttribute1:ctx.htmlAttribute()) {
            htmlAttributes.add(visitHtmlAttribute(htmlAttribute1));
        }
        List<HtmlContent> contents = new ArrayList<>();

        for (HtmlParser.HtmlContentContext content : ctx.htmlContent()) {
            contents.add((HtmlContent) visit(content));
        }

            Main.semanticError.getE1().check_E1(ctx.tagName(1).getText(), ctx.tagName(1).getStart().getLine());


        return new HtmlPairTag(tagName,htmlAttributes,contents);
    }

    @Override
    public HtmlSingleTag visitHtmlSingleTagSelfClosing(HtmlParser.HtmlSingleTagSelfClosingContext ctx) {
         List<HtmlAttribute> attributes=new ArrayList<>();
         for (HtmlParser.HtmlAttributeContext attribute:ctx.htmlAttribute()){
             attributes.add(visitHtmlAttribute(attribute));
         }
         TagName tagName=visitTagName(ctx.tagName());

        return new HtmlSingleTagSelfClosing(tagName,attributes);
    }




    @Override
    public HtmlAttribute visitHtmlAttribute(HtmlParser.HtmlAttributeContext ctx) {
        AttributeValue attributeValue=visitAttributeValue(ctx.attributeValue());

        AttributeKey attributeKey=visitAttributeKey(ctx.attributeKey());
        return new HtmlAttribute(attributeKey,attributeValue);
    }

    @Override
    public AttributeKey visitAttributeKey(HtmlParser.AttributeKeyContext ctx) {
        String key=ctx.getText();
        return new AttributeKey(key);
    }


    @Override
    public AttributeValue visitAttributeValue(HtmlParser.AttributeValueContext ctx) {

        String rawValue = ctx.getText();

        // 🔥 الحالة المهمة: يحتوي Jinja expression
        if (rawValue.contains("{{") && rawValue.contains("}}")) {

            // استخرج أول identifier داخل Jinja
            String inside = rawValue.substring(
                    rawValue.indexOf("{{") + 2,
                    rawValue.indexOf("}}")
            ).trim();

            // parse first identifier فقط (product)
            String first = inside.split("\\.")[0];

            boolean exists = Main.semanticError.getE4().exists_E4(first);

            if (!exists) {
                String fileName = ctx.start.getTokenSource().getSourceName();
                fileName = java.nio.file.Paths.get(fileName).getFileName().toString();

                Main.semanticError.getE5().addRequired(fileName, first);
            }

            // نرجع attribute يحتوي raw Jinja
            return new AttributeValue(rawValue);
        }

        // الحالة العادية
        AttributeValue.ValueType type;

        if (ctx.STRING() != null) {
            type = AttributeValue.ValueType.STRING;
            rawValue = rawValue.substring(1, rawValue.length() - 1);
        } else if (ctx.NUMBER() != null) {
            type = AttributeValue.ValueType.NUMBER;
        } else {
            type = AttributeValue.ValueType.IDENTIFIER;
        }

        AttributeValue attrValue = new AttributeValue(rawValue);

        try {
            java.lang.reflect.Field field = AttributeValue.class.getDeclaredField("type");
            field.setAccessible(true);
            field.set(attrValue, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attrValue;
    }


    @Override
    public TagName visitTagName(HtmlParser.TagNameContext ctx) {
        String tagname=ctx.getText();
        return new TagName(tagname);
    }

}