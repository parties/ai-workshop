# The Conversion Prompt

Turns an assignment your students AI'd their way through into one where their thinking is
visible.

## How to use it

1. Create a new **Project** (Claude), **Gem** (Gemini), or **Custom GPT** (ChatGPT)
2. Upload [`framework.md`](framework.md) to it
3. Copy the whole block below into the chat
4. Fill in the `MY CONTEXT` section — **this is the part that matters, don't skip it**
5. Attach or paste your assignment
6. Read what comes back, then **push back on it**

> **Upload your assignment, not your students' work.** If you want to show it what a kid
> actually turned in, strip the name first. See [the privacy section](README.md#student-privacy).

---

## Copy this

```
You have a document called framework.md describing a four-part prompt framework
(Verb, Format, Voice, Context). Read it before you respond.

I'm going to give you an assignment I've used with students. Students completed it
using AI in a way that bypassed the thinking I wanted them to do.

MY CONTEXT (I filled this in — use it, don't override it):
- Course and grade level:
- Length of a class period, and realistic work time in it:
- What my students can already do:
- What my students genuinely cannot do yet:
- The learning objective I actually care about here:
- What I have to keep (standards, required content, department rules):
- What went wrong when students used AI on this:

Do these five things, in this order, with a heading for each:

1. DIAGNOSE THE GAP
   Quote the original task. State exactly what a student has to know or decide
   BEFORE they can type it into an AI. If the honest answer is "nothing," say so
   plainly. Then name which specific thinking my objective required that the
   original task never forced.

2. REWRITE IT
   Produce a rewritten version built on the four parts. Label each part inline so
   I can see where Verb, Format, Voice, and Context landed. Keep my learning
   objective and anything I said I have to keep. Do not make it longer or fancier
   than the original — it has to fit the same class period.

3. SHOW ME THE DIFFERENCE
   A two-column table: "Student could skip this before" vs. "Student must do this
   now." One row per thinking move. Be concrete and specific to my subject.

4. TELL ME HOW TO GRADE IT
   Three or four things I can actually look at to tell whether the student did the
   thinking — including at least one that involves reading their prompt, not just
   their output.

5. FLAG THE WEAK POINTS
   Where could a student still shortcut this? Where might my students struggle for
   reasons that have nothing to do with AI? Be honest rather than encouraging.

RULES:
- If something in MY CONTEXT is missing or too vague to work with, ASK ME before
  you write the rewrite. Do not invent details about my classroom.
- Do not just add jargon to the original. If the student's required thinking hasn't
  changed, the rewrite failed.
- Plain language. I'm going to hand parts of this to teenagers.
- If you think the original assignment is fine as-is and AI wasn't really the
  problem, say that instead of rewriting it.
```

---

## Why the prompt looks like this

It's built on the framework it teaches, which is worth noticing:

- **Verb** — *diagnose, rewrite, compare, flag.* Four thinking moves, none of them "write."
- **Format** — five numbered sections, one with a required two-column table. Gaps show up structurally.
- **Voice** — an instructional coach who'll tell you your assignment is fine, not a cheerleader.
- **Context** — the block you fill in. Everything good comes from there.

The two rules doing the most work: **ask rather than invent**, and **say so if the rewrite
didn't change the required thinking.** Without those you get a polished assignment that still
has the same hole in it.

## If the output is disappointing

Almost always the `MY CONTEXT` block was thin. The two lines that carry the most weight:

- **"What my students genuinely cannot do yet"** — most people write what students *can* do. The limits are what make output usable.
- **"What went wrong when students used AI on this"** — be specific. "They turned in something generic" is weaker than "all twenty-eight described the same three safety hazards in the same order."

Push back in the chat rather than starting over. *"You kept the same thinking gap in step 2 —
a student can still ask for the whole table in one shot. Try again."* That iteration is
Discernment, and it's the part you want students watching you do.
