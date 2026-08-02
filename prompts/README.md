# Prompts

Every file in this folder is **the prompt itself** — no instructions mixed in. Open it, select
all, copy, paste. Nothing to strip out first.

| File | Use it when |
|---|---|
| [`conversion-prompt.md`](conversion-prompt.md) | You brought your own assignment. Fill in the **My context** section. |
| [`conversion-prompt-prefilled.md`](conversion-prompt-prefilled.md) | You didn't bring one. Context is already filled in for [`sample-assignment.md`](../resources/sample-assignment.md). Zero edits. |

> Tip: click **Raw** on GitHub before copying. You get the source, unmangled.

---

## How to run the conversion

1. Create a new **Project** (Claude), **Gem** (Gemini), or **Custom GPT** (ChatGPT)
2. Upload [`resources/framework.md`](../resources/framework.md) to it
3. Copy a prompt from the table above into the chat
4. Fill in the **My context** section — *unless you're using the prefilled one*
5. Attach your assignment as a file (txt, docx, pdf, md — doesn't matter)
6. Read what comes back, then **push back on it**

> **Upload your assignment, not your students' work.** If you want to show it what a kid
> actually turned in, strip the name first. See [Student privacy](../README.md#student-privacy).

---

## Why the prompt is written this way

It's built on the framework it teaches, which is worth noticing:

- **Verb** — *diagnose, rewrite, compare, flag.* Four thinking moves, none of them "write."
- **Format** — five numbered sections, one requiring a two-column table. Gaps show up structurally.
- **Voice** — an instructional coach who'll tell you your assignment is fine, not a cheerleader.
- **Context** — the block you fill in. Everything good comes from there.

Two rules do most of the work: **ask rather than invent**, and **say so if the rewrite didn't
change the required thinking.** Without them you get a polished assignment with the same hole
still in it.

## If the output is disappointing

Almost always the context block was thin. The two lines carrying the most weight:

- **"What my students genuinely cannot do yet"** — most people write what students *can* do. The limits are what make output usable.
- **"What went wrong when students used AI on this"** — be specific. *"They turned in something generic"* is much weaker than *"all twenty-eight described the same three safety hazards in the same order."*

Push back in the chat rather than starting over:

> *"You kept the same thinking gap in step 2 — a student can still ask for the whole table in
> one shot. Try again."*

That iteration is **Discernment**, and it's the part you want students watching you do.
